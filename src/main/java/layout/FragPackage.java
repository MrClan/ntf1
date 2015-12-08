package layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.apptivators.ntcore.ImageAdapter;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.ListingPage;
import com.apptivators.ntcore.R;

/**
 * Created on 12/7/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class FragPackage extends Fragment
{

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

    public static FragPackage newInstance() {
        Bundle args = new Bundle();
        FragPackage fragment = new FragPackage();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_package, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvPackage);
        gridview.setAdapter(new ImageAdapter(curActivity,1,mThumbIds,mThumbInfo));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                OnMenuButtonClicked(position);
            }
        });
        return view;
    }

    private void OnMenuButtonClicked(int position)
    {
        Activity ctx = getActivity();
        Intent i = new Intent(ctx, ListingPage.class);
        switch (position)
        {
            case 0:
                i.putExtra("dataType", TripType.ADVENTURE);
                break;
            case 1:
                i.putExtra("dataType", TripType.CASUAL);
                break;
            case 2:
                i.putExtra("dataType", TripType.EXPLORING);
                break;
            case 3:
                i.putExtra("dataType", TripType.FEATURED);
                break;
            case 4:
                i.putExtra("dataType", TripType.HIKING);
                break;
            case 5:
                i.putExtra("dataType", TripType.MOUNTAINEERING);
                break;
            case 6:
                i.putExtra("dataType", TripType.SOCIAL);
                break;
            case 7:
                i.putExtra("dataType", TripType.ROMANTIC);
                break;
            case 8:
                i.putExtra("dataType", TripType.FESTIVAL);
                break;
            default:
                i.putExtra("dataType", TripType.ADVENTURE);
                break;
        }

        if(i!= null) {
            i.putExtra("viewType", "Packages");
            ctx.startActivity(i);
        }
    }
}
