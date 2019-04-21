package com.messangerclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_new_message.*

class NewMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        supportActionBar?.title = "Select User"

        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(UserItem())
        adapter.add(UserItem())
        adapter.add(UserItem())
        adapter.add(UserItem())
        adapter.add(UserItem())
        adapter.add(UserItem())

        recyclerview_newmessage.adapter = adapter


        fetchUsers()

    }
    private  fun fetchUsers(){
        val ref = FirebaseDatabase.getInstance().getReference("/users")
        ref. addListenerForSingleValueEvent(object: ValueEventListener{

            // will be called all time we retrieve all the users inside of firebase
            override fun onDataChange(p0: DataSnapshot) {
                //reverting data into something easier to work with


                p0.children.forEach{
                    Log.d("New Message", it.toString())
                    val user = it.getValue(User::class.java)
                }
            }
            override fun onCancelled(p0: DatabaseError) {
            }
        })
    }
}
 class UserItem: Item<ViewHolder>(){
     override fun bind(viewHolder: ViewHolder, position: Int) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         // will be called in the list for each user object

     }
     override  fun getLayout(): Int{
         return  R.layout.user_row_new_message
     }
 }
