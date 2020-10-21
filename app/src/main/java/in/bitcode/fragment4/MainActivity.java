package in.bitcode.fragment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    private DataReaderFragment mDataReaderFragment;
    private DataViewFragment mDataViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mDataReaderFragment =
                (DataReaderFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentDataReader);

        //way 3.1
        //mDataReaderFragment.setOnDataReadListener(new MainActivityOnDataReadListener());

        mDataViewFragment =
                (DataViewFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentDataView);

        //way 3.2
        mDataReaderFragment.setOnDataReadListener(mDataViewFragment);
        mDataViewFragment.setOnDataUpdateListener(mDataReaderFragment);

    }

    //way 3.1
    class MainActivityOnDataReadListener implements DataReaderFragment.OnDataReadListener {
        @Override
        public void onData(String data) {
            mDataViewFragment.setData(data);
        }
    }


    //way 1
    public void sendDataToViewFragment(String data) {
        mDataViewFragment.setData(data);
    }
}