package com.example.bookslisttask.InterFace;



import com.example.bookslisttask.BookDetails.BooksDetais;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

 @GET("books/?mime_type=text%2F")
 Call<BooksDetais> books();


}
