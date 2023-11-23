package com.ahmedsohail.i200557;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ahmedsohail.i200557.Models.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder> {

    ChatFragment mainChat;
    Context a;
    ArrayList<Users> usersArrayList;
    public UserAdapter(ChatFragment mainChat, ArrayList<Users> usersArrayList) {
        this.mainChat = mainChat;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public UserAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mainChat.getLayoutInflater().inflate(R.layout.item_container_contact, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewholder holder, int position) {

        Users users = usersArrayList.get(position);
        holder.namee.setText(users.getUserName());
        Picasso.get().load(users.getProfilePic()).into(holder.ci);

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        CircleImageView ci;
        TextView namee;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            ci = itemView.findViewById(R.id.user_image);
            namee = itemView.findViewById(R.id.chat_name);
        }
    }
}
