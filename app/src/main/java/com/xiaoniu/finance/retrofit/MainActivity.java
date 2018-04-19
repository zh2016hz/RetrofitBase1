package com.xiaoniu.finance.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.xiaoniu.finance.retrofit.data.ApiUtils;
import com.xiaoniu.finance.retrofit.data.model.Item;
import com.xiaoniu.finance.retrofit.data.model.SOAnswersResponse;
import com.xiaoniu.finance.retrofit.data.remote.AnswersAdapter;
import com.xiaoniu.finance.retrofit.data.remote.SOService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SOService mService;
    private RecyclerView mRecyclerView;
    private AnswersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<List<SOAnswersResponse>>() {
            public static final String TAG = "";

            @Override
            public void onResponse(Call<List<SOAnswersResponse>> call, Response<List<SOAnswersResponse>> response) {
              Toast.makeText(MainActivity.this,"成功　",Toast.LENGTH_LONG).show();
                Log.e(TAG, "onResponse: 成功" );

                if(response.isSuccessful()) {
                    response.body();
//                    mAdapter.updateAnswers(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<SOAnswersResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"失败　",Toast.LENGTH_LONG).show();
                Log.e(TAG, "onResponse: 失败 " );
            }
        });
    }

    private void showErrorMessage() {
    }

}




