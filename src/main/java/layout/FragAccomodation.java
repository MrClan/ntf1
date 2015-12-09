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
public class FragAccomodation extends Fragment
{
    private Integer[] mThumbIdsTransportation =
            {
                    R.drawable.img_menu_acomodation_fivestarhotel,
                    R.drawable.img_menu_acomodation_premiumhotel,
                    R.drawable.img_menu_acomodation_villa,
                    R.drawable.img_menu_acomodation_budgethotel,
                    R.drawable.img_menu_acomodation_homestay,
                    R.drawable.img_menu_acomodation_motel
            };

    private String[] mThumbIdsTransportationNames =
            {
                    "5 Star Hotel",
                    "Premium Hotel",
                    "Villa",
                    "Budget Hotel",
                    "Homestay",
                    "Motel"
            };
    static Class targetActivity = null;
    final static SquareImageAdapter.ItemType ITEM_TYPE = SquareImageAdapter.ItemType.ACCOMODATION;
    private int mPage;

    public static FragAccomodation newInstance(Class tgtActivity) {
        Bundle args = new Bundle();
        FragAccomodation fragment = new FragAccomodation();
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
        final View view = inflater.inflate(R.layout.frag_accomodation, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvAccomodation);
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
