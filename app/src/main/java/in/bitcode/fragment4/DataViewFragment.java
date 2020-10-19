package in.bitcode.fragment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataViewFragment extends Fragment {

    private TextView mTxtData;
    private Button mBtnPutBack;
    private String mData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_view, null);

        mTxtData = view.findViewById(R.id.txtData);
        mBtnPutBack = view.findViewById(R.id.btnPutBack);

        mBtnPutBack.setOnClickListener(new BtnPutBackClickListener());

        return view;
    }


    public void setData(String data) {
        mData = data;
        mTxtData.setText(data);
    }

    private class BtnPutBackClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            //way 2
            DataReaderFragment dataReaderFragment =
                    (DataReaderFragment) getFragmentManager()
                            .findFragmentById(R.id.fragmentDataReader);

            dataReaderFragment.setData(mData.toUpperCase());
        }
    }
}
