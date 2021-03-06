package layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.apptivators.ntcore.ImageAdapter;
import com.apptivators.ntcore.PackageActivity;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;
import com.apptivators.ntcore.dialogtest;

/**
 * Created on 12/7/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class FragFacility extends Fragment
{

    static Class targetActivity = null;
    private int mPage;
    private Integer[] mThumbIds = {
            R.drawable.img_featured,
            R.drawable.img_adventure,
            R.drawable.img_casual,
            R.drawable.img_romantic,
            R.drawable.img_hiking,
            R.drawable.img_mountaineering,
            R.drawable.img_exploring,
            R.drawable.img_social,
            R.drawable.img_festival
    };

    private String[] mThumbInfo = {
            "Featured",
            "Adventure",
            "Casual",
            "Romantic",
            "Hiking",
            "Mountaineering",
            "Exploring",
            "Social",
            "Festival",
    };
    public static FragFacility newInstance(Class tgtActivity) {
        Bundle args = new Bundle();
        FragFacility fragment = new FragFacility();
        fragment.setArguments(args);
        targetActivity = tgtActivity;
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_facility, container, false);
        final Activity curActivity = getActivity();
        return view;
    }


}
