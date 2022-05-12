package com.example.friendlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    //constructor
    open fun RecyclerAdapter(c: Context) {

        //set our context
        this.mContext = c;
    }

    //arrays for data information (name/img/address/number)
    private val names = arrayOf("Tyler Martin", "John Doe", "Jane Doe", "Josh Livet", "Scott Adams", "Kim Dawns", "John Adams", "George Bills", "Thomas Jeff", "Chris Johnson");
    private val numbers = arrayOf("(314) 654-2315", "(612) 817-9312", "(314) 560-1928", "(628) 299-3992", "(314) 729-7725", "(612) 895-8485", "(314) 324-1773", "(628) 599-7232", "(314) 772-5213", "(628) 945-5633");
    private val address = arrayOf("32 John Street", "50 Bill Ave", "123 Butch Hill", "77 South Conner Street", "43 Bill Avenue", "21 North Bend", "23 South Bend", "112 John Plaza", "64 Nintendo Lane", "10 Pull Street");
    private val profileimgs = arrayOf(R.drawable.person_icon, R.drawable.person_icon_b, R.drawable.person_icon_bl, R.drawable.person_icon_g, R.drawable.person_icon_p, R.drawable.person_icon_o, R.drawable.person_icon_r, R.drawable.person_icon_gy, R.drawable.person_icon_y, R.drawable.person_icon_lg)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_friend, parent, false);
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = names[position];
        holder.itemAddress.text = address[position];
        holder.itemNumber.text = numbers[position];
        holder.itemImage.setImageResource(profileimgs[position]);
    }

    override fun getItemCount(): Int {
        return names.size
    }

    //ViewHolder Class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView;
        var itemTitle: TextView;
        var itemAddress: TextView;
        var itemNumber: TextView;

        init{
            itemImage = itemView.findViewById(R.id.profileimage);
            itemTitle = itemView.findViewById(R.id.profilename);
            itemAddress = itemView.findViewById(R.id.profileaddress);
            itemNumber = itemView.findViewById(R.id.profilenumber);

            //set listener for clicks
            itemView.setOnClickListener(){

                //get pos
                val position: Int = adapterPosition;

                //make new intent
                val intent = Intent(itemView.getContext(), FriendInfo::class.java)

                //set extras
                intent.putExtra("Address", address[position])
                intent.putExtra("Name", names[position])
                intent.putExtra("Phone", numbers[position])
                intent.putExtra("Picture", profileimgs[position])

                //start
                itemView.getContext().startActivity(intent)
            }
        }

    }
}