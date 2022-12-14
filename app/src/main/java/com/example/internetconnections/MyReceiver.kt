package com.example.internetconnections

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    var dialog :Dialog? = null
    override fun onReceive(context: Context, intent: Intent) {
        var status = NetWorkUtill.getConnectionStatusString(context!!)
        dialog = Dialog(context,android.R.style.Theme_NoTitleBar_Fullscreen)
        dialog!!.setContentView(R.layout.customdialog)

        val reStartApp = dialog!!.findViewById<Button>(R.id.restrart)
        reStartApp.setOnClickListener{
            context.startActivity(Intent(context,MainActivity::class.java))
        }
        if (status!!.isEmpty() || status == "No Internet is available"
            || status == "No Internet Connection" ){
            status = "No Internet Connection"
            dialog!!.show()
        }
        Toast.makeText(context,status, Toast.LENGTH_SHORT).show()
    }
}
