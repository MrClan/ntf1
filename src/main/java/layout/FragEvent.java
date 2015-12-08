package layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.apptivators.ntcore.CityListActivity;
import com.apptivators.ntcore.ListingPage;
import com.apptivators.ntcore.Models.TripType;
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;

/**
 * Created on 12/7/2015
 * By : $(USER)<suchan211@gmail.com>
 */
public class FragEvent extends Fragment {

    private int mPage;

    public static FragEvent newInstance() {
        Bundle args = new Bundle();
        FragEvent fragment = new FragEvent();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_event, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvEvent);
        gridview.setAdapter(new SquareImageAdapter(curActivity, SquareImageAdapter.ItemType.DESTINATION));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Context ctx = view.getContext();
                // load romantic city list


                Intent i = new Intent(ctx, ListingPage.class);;
                switch (position) {
                    default:
                        break;
                }
                if (i != null) {
                    i.putExtra("viewType", "Events");
                    i.putExtra("dataType", "SocialEvents");
                    ctx.startActivity(i);
                }
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
}
