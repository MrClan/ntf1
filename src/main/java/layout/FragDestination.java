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

import com.apptivators.ntcore.R;
import com.apptivators.ntcore.Utils.SquareImageAdapter;
import com.apptivators.ntcore.dialogtest;

/**
 * Created by Pratik on 12/6/2015.
 */
public class FragDestination extends Fragment {

    static Class targetActivity = null;
    private int mPage;

    public static FragDestination newInstance(Class tgtActivity) {
        Bundle args = new Bundle();
        FragDestination fragment = new FragDestination();
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
        final View view = inflater.inflate(R.layout.frag_destination, container, false);
        final Activity curActivity = getActivity();
        GridView gridview = (GridView) view.findViewById(R.id.gvDestination);
        gridview.setAdapter(new SquareImageAdapter(curActivity));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(curActivity, "" + position,
                        Toast.LENGTH_SHORT).show();

                if (targetActivity != null) {
                    startActivity(new Intent(view.getContext(), targetActivity));
                }

                // start target activity on click
            }
        });

        ((Button)view.findViewById(R.id.btnDialog)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), dialogtest.class));
            }
        });


        return view;
    }
}
