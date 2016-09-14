package course.labs.activitylab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

    // string for logcat documentation
    private final static String TAG = "Lab-ActivityOne";
    private TextView tv_onCreate, tv_onStart, tv_onResume, tv_onPause, tv_onStop, tv_onDestory, tv_onRestart;


    // lifecycle counts
    //TODO:
    //Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
    // You will need to increment these variables' values when their corresponding lifecycle methods get called.
    private int onCreate_count, onStart_count,onResume_count,onPause_count,onStop_count,onDestory_count,onRestart_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        createViews();
        if( savedInstanceState != null)
            restoreCountValues(savedInstanceState);

        SharedPreferences prefs = this.getPreferences(getApplicationContext().MODE_PRIVATE);
        if(prefs != null) {
            onCreate_count = prefs.getInt("onCreate_count", 0);
            onStart_count = prefs.getInt("onStart_count", 0);
            onResume_count = prefs.getInt("onResume_count", 0);
            onPause_count = prefs.getInt("onPause_count", 0);
            onStop_count = prefs.getInt("onStop_count", 0);
            onRestart_count = prefs.getInt("onRestart_count", 0);
            onDestory_count = prefs.getInt("onDestroy_count", 0);
        }

        //Log cat print out
        Log.i(TAG, "onCreate called");

        //TODO:
        //update the appropriate count variable
        //update the view
        onCreate_count++;
        tv_onCreate.setText(getString(R.string.onCreate) + String.valueOf(onCreate_count));


    }

    private void restoreCountValues(Bundle savedInstanceState) {

        onCreate_count = savedInstanceState.getInt("onCreate_count");
        onStart_count = savedInstanceState.getInt("onStart_count");
        onResume_count = savedInstanceState.getInt("onResume_count");
        onPause_count = savedInstanceState.getInt("onPause_count");
        onStop_count = savedInstanceState.getInt("onStop_count");
        onRestart_count = savedInstanceState.getInt("onRestart_count");
        onDestory_count = savedInstanceState.getInt("onDestroy_count");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_one, menu);
        return true;
    }

    // lifecycle callback overrides

    @Override
    public void onStart() {
        super.onStart();

        //Log cat print out
        Log.i(TAG, "onStart called");

        //TODO:
        //update the appropriate count variable
        //update the view
        onStart_count++;
        tv_onStart.setText(getString(R.string.onStart) + String.valueOf(onStart_count));
    }

    // TODO: implement 5 missing lifecycle callback methods

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG,"onResume called");
        onResume_count++;
        tv_onResume.setText(getString(R.string.onResume) + String.valueOf(onResume_count));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called");
        onStop_count++;
        tv_onStop.setText(getString(R.string.onStop) + String.valueOf(onStop_count));
        SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("onCreate_count", onCreate_count);
        editor.putInt("onStart_count", onStart_count);
        editor.putInt("onResume_count", onResume_count);
        editor.putInt("onPause_count", onPause_count);
        editor.putInt("onStop_count", onStop_count);
        editor.putInt("onRestart_count", onRestart_count);
        editor.putInt("onDestroy_count", onDestory_count);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called");
        onDestory_count++;
        tv_onDestory.setText(getString(R.string.onDestroy) + String.valueOf(onDestory_count));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause called");
        onPause_count++;
        tv_onPause.setText(getString(R.string.onPause) + String.valueOf(onPause_count));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart called");
        onRestart_count++;
        tv_onRestart.setText(getString(R.string.onRestart) + String.valueOf(onRestart_count));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //TODO:
        // save state information with a collection of key-value pairs
        // save all  count variables
        Log.i(TAG, "Called onSaveInstanceState");
        savedInstanceState.putInt("onCreate_count", onCreate_count);
        savedInstanceState.putInt("onStart_count", onStart_count);
        savedInstanceState.putInt("onResume_count", onResume_count);
        savedInstanceState.putInt("onPause_count", onPause_count);
        savedInstanceState.putInt("onStop_count", onStop_count);
        savedInstanceState.putInt("onRestart_count", onRestart_count);
        savedInstanceState.putInt("onDestroy_count", onDestory_count);


    }

    public void launchActivityTwo(View view) {
        //TODO:
        // This function launches Activity Two.
        // Hint: use Context’s startActivity() method.
        Intent intent = new Intent(this, ActivityTwo.class);
        this.startActivity(intent);
    }

    private void createViews(){
        tv_onCreate = (TextView)findViewById(R.id.create);
        tv_onDestory = (TextView)findViewById(R.id.destroy);
        tv_onPause = (TextView)findViewById(R.id.pause);
        tv_onRestart = (TextView)findViewById(R.id.restart);
        tv_onResume = (TextView)findViewById(R.id.resume);
        tv_onStart = (TextView)findViewById(R.id.start);
        tv_onStop = (TextView)findViewById(R.id.stop);

    }


}
