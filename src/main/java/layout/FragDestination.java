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
import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;

/**
 * Created by Pratik on 12/6/2015.
 */
public class FragDestination extends Fragment {

    final static SquareImageAdapter.ItemType ITEM_TYPE = SquareImageAdapter.ItemType.DESTINATION;
    private int mPage;

    public static FragDestination newInstance() {
        Bundle args = new Bundle();
        FragDestination fragment = new FragDestination();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_destination, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvDestination);
        gridview.setAdapter(new SquareImageAdapter(curActivity, ITEM_TYPE));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent i = null;

                Context ctx = view.getContext();
                switch (position) {
                    case 1:
                        // load romantic city list
                        i = new Intent(ctx, CityListActivity.class);
                        i.putExtra("dataType", "RomanticCities");
                        break;
                    case 2:
                        // load romantic city list
                        i = new Intent(ctx, ListingPage.class);
                        i.putExtra("dataType", "RomanticCities");
                        break;
                    default:
                        break;
                }
                if (i != null) {
                    i.putExtra("viewType", "Packages");
                    ctx.startActivity(i);
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
