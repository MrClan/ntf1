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
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;

/**
 * Created by suchan on 12/6/2015.
 */
public class FragTransportation extends Fragment
{

    static Class targetActivity = null;
    final static SquareImageAdapter.ItemType ITEM_TYPE = SquareImageAdapter.ItemType.TRANSPORTATION;
    private int mPage;

    public static FragTransportation newInstance(Class tgtActivity) {
        Bundle args = new Bundle();
        FragTransportation fragment = new FragTransportation();
        fragment.setArguments(args);
        targetActivity = tgtActivity;
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private Integer[] mThumbIdsTransportation =
            {
                    R.drawable.flight,
                    R.drawable.micro_bus_4,
                    R.drawable.taxi1,
                    R.drawable.sajha_yatayat,
                    R.drawable.img_menu_transportation_bus,
                    R.drawable.img_menu_transportation_taxi
            };

    private String[] mThumbIdsTransportationNames =
            {
                    "Book a flights",
                    "Reserve a micro",
                    "Hire a taxi",
                    "Buy bus tickets",
                    "Reserve a bus",
                    "Rent cab for a day"
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_transportation, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvTransportation);
        //gridview.setAdapter(new SquareImageAdapter(curActivity, ITEM_TYPE));
        gridview.setAdapter(new ImageAdapter(curActivity, 1, mThumbIdsTransportation, mThumbIdsTransportationNames ));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


                if (targetActivity != null) {
                    startActivity(new Intent(view.getContext(), targetActivity));
                }

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
}
