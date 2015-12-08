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

import com.apptivators.ntcore.EventListingPage;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.PackageActivity;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;

/**
 * Created on 12/7/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class FragPackage extends Fragment
{

    static Class targetActivity = null;
    private int mPage;

    public static FragPackage newInstance(Class tgtActivity) {
        Bundle args = new Bundle();
        FragPackage fragment = new FragPackage();
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
        final View view = inflater.inflate(R.layout.frag_package, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvPackage);
        gridview.setAdapter(new SquareImageAdapter(curActivity, SquareImageAdapter.ItemType.DESTINATION));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(curActivity, "" + position,
                        Toast.LENGTH_SHORT).show();

                if (targetActivity != null) {
                    startActivity(new Intent(view.getContext(), targetActivity));
                }
                OnMenuButtonClicked(position);
                // start target activity on click
            }
        });

//        ((Button)view.findViewById(R.id.btnDialog)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(view.getContext(), dialogtest.class));
//            }
//        });


        return view;
    }

    private void OnMenuButtonClicked(int position)
    {
        Activity ctx = getActivity();
        Intent i = null;
        switch (position)
        {
            case 0:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.ADVENTURE);
                break;
            case 1:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.CASUAL);
                break;
            case 2:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.EXPLORING);
                break;
            case 3:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.FEATURED);
                break;
            case 4:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.HIKING);
                break;
            case 5:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.MOUNTAINEERING);
                break;
            case 6:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.SOCIAL);
                break;
            case 7:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.ROMANTIC);
                break;
            case 8:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.FESTIVAL);
                break;
            default:
                i = new Intent(ctx, EventListingPage.class);
                i.putExtra("dataType", TripType.ADVENTURE);
                break;
        }
        ctx.startActivity(i);
    }
}
