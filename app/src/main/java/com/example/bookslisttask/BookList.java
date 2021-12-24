package com.example.bookslisttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookslisttask.BookDetails.BooksDetais;
import com.example.bookslisttask.BookDetails.Result;
import com.example.bookslisttask.InterFace.APIInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookList extends AppCompatActivity {
    RecyclerView book_recyclerview;
    List<BooksModel> productListModels;
    BookListAdapter productListAdapter;
    APIInterface apiInterface;
    EditText etSearch;
    ImageView back,cencle;
    TextView title;
    String titleeee="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        etSearch=findViewById(R.id.etSearch);
        back=findViewById(R.id.back);
        cencle=findViewById(R.id.cencle);
        title=findViewById(R.id.title);
        Intent i=getIntent();
        titleeee=i.getStringExtra("title");
        title.setText(titleeee);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cencle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setText("");
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if (s.length()>0)
               {
                   cencle.setVisibility(View.VISIBLE);
                   String text = etSearch.getText().toString().toLowerCase(Locale.getDefault());
                   filter(text);
               }else {
                   cencle.setVisibility(View.GONE);
               }

            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = etSearch.getText().toString().toLowerCase(Locale.getDefault());
                filter(text);
            }
        });



        productListModels=new ArrayList<>();
        book_recyclerview=findViewById(R.id.book_recyclerview);
        book_recyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        GetProductList();
    }

    void filter(String text){

        Log.v("jdfskdf","1"+text);
        Log.v("dsfjfds","2"+productListModels.size());
        ArrayList<BooksModel> temp = new ArrayList();
        for(int i=0; i<productListModels.size(); i++){
            Log.v("fsdkjsd",""+productListModels.get(i).getBooktitle());
            if(productListModels.get(i).getBooktitle().toLowerCase(Locale.getDefault()).contains(text.toLowerCase(Locale.getDefault()))){
                Log.e("jdshf","1");
                temp.add(productListModels.get(i));
            }else   if(productListModels.get(i).getBookauthor().toLowerCase(Locale.getDefault()).contains(text.toLowerCase(Locale.getDefault()))){

                temp.add(productListModels.get(i));
                Log.e("jdshf","2");
            }else {
                Log.e("jdshf","3");

            }
        }
        try{
            productListAdapter.updateList(temp);
        }catch ( Exception e){}
    }


    public  void  GetProductList()
    {


        //    Log.v("vxhgkhs",""+jsonObject);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<BooksDetais> call = apiInterface.books();
        call.enqueue(new Callback<BooksDetais>() {
            @Override
            public void onResponse(Call<BooksDetais> call, Response<BooksDetais> response) {

                BooksDetais  getProductList=response.body();
                if (response.isSuccessful()) {

                    List<Result> list = getProductList.getResults();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getAuthors().isEmpty())
                        {

                        }else {
                            productListModels.add(new BooksModel(list.get(i).getId() + "", list.get(i).getFormats().getImageJpeg(),""+ list.get(i).getFormats().getTextHtmlCharsetUtf8(), list.get(i).getTitle(), list.get(i).getAuthors().get(0).getName() + ""));
                            productListAdapter = new BookListAdapter(getApplicationContext(), productListModels);
                            book_recyclerview.setAdapter(productListAdapter);
                        }
                    }

                }
                else {


                }
            }

            @Override
            public void onFailure(Call<BooksDetais> call, Throwable t) {

            }

        });

    }









}