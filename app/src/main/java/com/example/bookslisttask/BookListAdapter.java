package com.example.bookslisttask;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.RRViewHolder> {
    private Context context;
    private List<BooksModel> arraylist;
//    Preferences pref;
    String CustomerID,ProductID,Quantity;

    public BookListAdapter(Context context, List<BooksModel> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @NonNull
    @Override
    public RRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
            return new RRViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RRViewHolder holder, final int position) {
        BooksModel arrayList=arraylist.get(position);

     holder.book_title.setText(arrayList.getBooktitle());
     holder.book_author.setText(arrayList.getBookauthor());
        Glide.with(context).load(arrayList.getBookpath()).placeholder(R.drawable.placeholder11).into(holder.book_img);


         holder.ll_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
try {


    Uri uri = Uri.parse(arrayList.getBooklink());
    if (uri.toString().contains(".htm")) {


        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setDataAndType(Uri.parse(arrayList.getBooklink()), "text/html");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }else {
        Toast.makeText(context, "“No viewable version available”.", Toast.LENGTH_SHORT).show();
    }
}catch (ActivityNotFoundException e) {
    Toast.makeText(context, "No application found which can open the file", Toast.LENGTH_SHORT).show();
}


             }

         });

    }


    public void updateList(ArrayList<BooksModel> list){
        arraylist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class RRViewHolder extends RecyclerView.ViewHolder{
        TextView book_title,book_author;
        ImageView book_img;
        LinearLayout ll_layout;

        public RRViewHolder(@NonNull View itemView) {
            super(itemView);
            book_img = itemView.findViewById(R.id.book_img);
            book_title = itemView.findViewById(R.id.book_title);
            book_author = itemView.findViewById(R.id.book_author);
            ll_layout = itemView.findViewById(R.id.ll_layout);

        }
    }
}
