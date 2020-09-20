package com.genxmultiplexer.roomdatabase.utils

import android.content.Context
import android.os.Message
import android.widget.Toast

fun Context.toast(msg:String)=Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
