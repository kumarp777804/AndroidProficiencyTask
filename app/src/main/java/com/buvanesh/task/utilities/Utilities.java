package com.buvanesh.task.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.buvanesh.task.R;

public class Utilities {

    /**
     * To check the Internet connection
     * @param context reference of the activity
     * */
    public static boolean isConnected(Context context) {
        final ConnectivityManager conMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.getState() == NetworkInfo.State.CONNECTED;
    }

    /**
     * To set the Layout manager and Divider for recyclerView
     * @param context reference of the activity
     * @param recyclerView object of recyclerView
     * */
    public static void setRecyclerViewAnimator(Context context,RecyclerView recyclerView){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration decorator = new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decorator);
    }

    /**
     * To popup the alert message
     * @param context reference of the activity
     * @param message represents the popup message
     * */
    public static void showAlert(Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.warning));
        builder.setMessage(message);
        builder.setPositiveButton(context.getResources().getString(R.string.okay),
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
