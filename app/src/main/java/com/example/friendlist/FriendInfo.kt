package com.example.friendlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.friendlist.databinding.ActivityFriendInfoBinding

class FriendInfo : AppCompatActivity() {

    //setup main access
    private lateinit var mainEnv: ActivityFriendInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind
        mainEnv = ActivityFriendInfoBinding.inflate(layoutInflater)

        //set env
        setContentView(mainEnv.root)
        
        //get the string values passed by the activity intent
        mainEnv.Name.text = intent.getStringExtra("Name");
        mainEnv.PhoneNumber.text = "Number: " + intent.getStringExtra("Phone").toString();
        mainEnv.Address.text = "Address: " + intent.getStringExtra("Address").toString();

        //get the profile image
        mainEnv.profileImg.setImageResource(intent.getIntExtra("Picture", 1));

        //remove the title bar
        this.supportActionBar!!.hide()

        //set button listener
        mainEnv.Back.setOnClickListener(){

            //make new intent
            var intent = Intent(applicationContext, MainActivity::class.java);

            //transition backwards
            startActivity(intent);

        }

    }
}