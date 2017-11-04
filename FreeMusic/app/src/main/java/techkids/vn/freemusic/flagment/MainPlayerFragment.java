package techkids.vn.freemusic.flagment;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thin.downloadmanager.DefaultRetryPolicy;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListener;
import com.thin.downloadmanager.ThinDownloadManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import techkids.vn.freemusic.R;
import techkids.vn.freemusic.databases.TopSongModel;
import techkids.vn.freemusic.events.OnTopSongEvent;
import techkids.vn.freemusic.utils.MusicHandle;
import techkids.vn.freemusic.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPlayerFragment extends Fragment {
    @BindView(R.id.iv_close)
    ImageView ivClose ;
    @BindView(R.id.iv_download)
    ImageView ivDownload;
    @BindView(R.id.tv_song_name)
    TextView tvSongName;
    @BindView(R.id.tv_singer_name)
    TextView tvSinger;
    @BindView(R.id.iv_song)
    ImageView ivSong;
    @BindView(R.id.tv_duration_time_song)
    TextView tvDuration;
    @BindView(R.id.tv_current_time_song)
    TextView tvCurrent;
    @BindView(R.id.sb_main)
    SeekBar sbMain;
    @BindView(R.id.iv_pre)
    ImageView ivPrevious;
    @BindView(R.id.fb_play)
    FloatingActionButton fbPlay;
    @BindView(R.id.iv_next)
    ImageView ivNext;
    public TopSongModel topSongModel;
    public ThinDownloadManager downloadManager = new ThinDownloadManager(4);

    public MainPlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainplayer, container,
                false);
        setupUI(view);
        EventBus.getDefault().register(this);
        return view;
    }
    @Subscribe(sticky = true)
    public void onReceiveTopSong(OnTopSongEvent onTopSongEvent){
        topSongModel = onTopSongEvent.getTopSongModel();
        tvSinger.setText(topSongModel.getArtist());
        tvSongName.setText(topSongModel.getSong());
        Picasso.with(getContext()).load(topSongModel.getLargeImage())
                .transform(new CropCircleTransformation())
                .into(ivSong);
        MusicHandle.updateRealtime(sbMain, fbPlay, ivSong, tvCurrent, tvDuration);
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);
        fbPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicHandle.playAndPause();
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        ivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = topSongModel.getSong() + "-" + topSongModel.getArtist() + ".mp3";
                boolean downloaded = false;

                    for (File file : Utils.getMusicDownloaded(getContext())) {
                        if (fileName.equals(file.getName())) {
                            downloaded = true;
                            Toast.makeText(getContext(), "Exited song", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }


                if (!downloaded) {
                    Toast.makeText(getContext(), "Ready to download", Toast.LENGTH_SHORT).show();
                    Uri downloadUri = Uri.parse(topSongModel.getUrl());
                    Uri destinationUri = Uri.parse(getContext().getExternalFilesDir("")
                            + "/"
                            + topSongModel.getSong()
                            + "-"
                            + topSongModel.getArtist()
                            + ".mp3");
                    DownloadRequest downloadRequest = new DownloadRequest(downloadUri)
                            .setRetryPolicy(new DefaultRetryPolicy())
                            .setDestinationURI(destinationUri).setPriority(DownloadRequest.Priority.HIGH)
                            .setDownloadContext("Download1")
                            .setDownloadListener(new DownloadStatusListener() {
                                @Override
                                public void onDownloadComplete(int id) {
                                    Toast.makeText(getContext(), "Complete download", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onDownloadFailed(int id, int errorCode, String errorMessage) {
                                    Toast.makeText(getContext(), "Denied", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onProgress(int id, long totalBytes, long downloadedBytes, int progress) {

                                }
                            });
                    downloadManager.add(downloadRequest);
                } else {
                    Toast.makeText(getContext(), "Exited song", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
