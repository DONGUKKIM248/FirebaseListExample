package com.example.firebaselistexample;
//Recycler Adapter를 만들어야 한다.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
//Alt+Enter 4번으로 Adapter의 기본 구색을 만들어 냈다.

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override //CUstomViewHolder에 대한 클래스를 만들어 준다.
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ListView가 Adapter에 연결된 다음
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override //
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_id.setText(arrayList.get(position).getPw());
        holder.tv_id.setText(arrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder { //상속을 해준다.
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_userName;
        public CustomViewHolder(@NonNull View itemView) { //생성자가 없으니 만들어라
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_userName = itemView.findViewById(R.id.tv_userName);
        }
    }
}
