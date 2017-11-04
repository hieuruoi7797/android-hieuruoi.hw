package techkids.vn.freemusic.flagment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.freemusic.R;
import techkids.vn.freemusic.adapter.TopSongAdapter;
import techkids.vn.freemusic.databases.TopSongModel;
import techkids.vn.freemusic.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadFragment extends Fragment {

    @BindView(R.id.rv_download)
    RecyclerView rvDownload;

    private List<TopSongModel> topSongModels;
    private TopSongAdapter topSongAdapter;

    public DownloadFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_download, container, false);
        loadData(view);
        setupUI(view);
        return view;
    }

    private void loadData(View view) {
        topSongModels = Utils.getListSongsDownloaded(getContext());
    }

    public void setupUI(View view) {
        ButterKnife.bind(this, view);

        topSongAdapter = new TopSongAdapter(getContext(), topSongModels);
        rvDownload.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDownload.setAdapter(topSongAdapter);

    }
}