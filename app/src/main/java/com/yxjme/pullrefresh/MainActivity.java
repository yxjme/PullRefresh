package com.yxjme.pullrefresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //下面示例中的值等于默认值
        RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));//设置Header
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));//设置Footer
        refreshLayout.autoRefresh();//自动刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                    }
                },3000);
            }
        });


        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadMoreWithNoMoreData();//完成加载并标记没有更多数据 1.0.4
                    }
                },3000);
            }
        });
    }
}
