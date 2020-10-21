package in.bitcode.fragment4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataReaderFragment extends Fragment implements OnDataUpdateListener {

    private Button mBtnSendData;
    private EditText mEdtData;

    public interface OnDataReadListener{
        public void onData(String data);
    }

    private OnDataReadListener mOnDataReadListener;

    public void setOnDataReadListener(OnDataReadListener onDataReadListener) {
        this.mOnDataReadListener = onDataReadListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_reader, null);
        mEdtData = view.findViewById(R.id.edtData);
        mBtnSendData = view.findViewById(R.id.btnSendData);

        mBtnSendData.setOnClickListener(new BtnSendDataClickListener());

        return view;
    }


    private class BtnSendDataClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            //way 1
            //((MainActivity)getActivity()).sendDataToViewFragment(mEdtData.getText().toString());

            //way 2
            /*
            DataViewFragment dataViewFragment =
                    (DataViewFragment) getFragmentManager()
                            .findFragmentById(R.id.fragmentDataView);

            dataViewFragment.setData(mEdtData.getText().toString());
            */

            //way 3
            if( mOnDataReadListener != null) {
                mOnDataReadListener.onData(mEdtData.getText().toString());
            }

        }
    }

    public void setData(String data) {
        mEdtData.setText(data);
    }

    @Override
    public void onUpdate(String data) {
        mEdtData.setText(data);
    }
}
