package jp.techacademy.shogo.aisatsuapp

import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeButton.setOnClickListener(this)
    }

    override fun onClick(v:View){
        if (v.id == R.id.timeButton ){
            showTimePickerDialog()
        }


    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view,hour,minute ->
                showMessage(hour,minute)
            }
            ,12,0,true)
        timePickerDialog.show()


    }
    private fun showMessage(hour:Int,munute:Int){
        var textMessage =""
        if(hour in 2..9){
           textMessage = "おはよう"
        } else if (hour in 10..17){
            textMessage = "こんにちは"
        } else if (hour >= 18 || hour < 2){
            textMessage = "こんばんは"
        }
        message.text = "%02d".format(hour) +":%02d".format(munute) +"  $textMessage"
    }

}
