package techkids.vn.thiendia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admins on 9/5/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel> {
    private Context context;
    private int resource;
    private List<StoryModel> storyModelList;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource,
                        @NonNull List<StoryModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.storyModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        StoryModel storyModel = storyModelList.get(position);

        View vBookmark = convertView.findViewById(R.id.v_bookmark);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tv_author);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());


        

        String encodedString = storyModel.getImage();

        final String pureBase64Encoded = encodedString.substring(encodedString.indexOf(",")  + 1);

        final byte[] decodedBytes = Base64.decode(pureBase64Encoded, Base64.DEFAULT);

        Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);





        tvTitle.setText(storyModel.getTitle());

        tvAuthor.setText(storyModel.getAuthor());

        ivStory.setImageBitmap(decodedBitmap);

        return convertView;
    }
}
