package com.buvanesh.task;


import android.support.v7.widget.RecyclerView;

import com.buvanesh.task.adapter.NewsFeedAdapter;
import com.buvanesh.task.model.NewsFeedModel;
import com.buvanesh.task.utilities.Utilities;
import com.buvanesh.task.view.NewsFeedActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class NewsFeedActivityTest {
    public NewsFeedActivity newsFeedActivity;
    public RecyclerView recyclerView;

    @Before
    public void setup(){
        newsFeedActivity = Robolectric.buildActivity(NewsFeedActivity.class)
                .create().get();
        recyclerView = (RecyclerView)newsFeedActivity.findViewById(R.id.recycler_news_feed);
    }

    @Test
    public void viewErrorTest(){
        Assert.assertNull(recyclerView.getAdapter());
        Assert.assertEquals(recyclerView.getChildCount(),0);
        Assert.assertNull(recyclerView.getItemAnimator());
        Assert.assertEquals(recyclerView.getItemDecorationCount(),0);
        Assert.assertNull(recyclerView.getLayoutManager());
    }

    @Test
    public void viewTest(){
        Assert.assertNotNull(newsFeedActivity);
        Assert.assertNotNull(recyclerView);
        recyclerView.setAdapter(new NewsFeedAdapter(getAdapterData()));
        Assert.assertNotNull(recyclerView.getAdapter());
        Utilities.setRecyclerViewAnimator(newsFeedActivity,recyclerView);
        Assert.assertEquals(recyclerView.getAdapter().getItemCount(),1);
        Assert.assertNotNull(recyclerView.getItemAnimator());
        Assert.assertEquals(recyclerView.getItemDecorationCount(),1);
        Assert.assertNotNull(recyclerView.getLayoutManager());
    }

    public List<NewsFeedModel.Row> getAdapterData(){
        List<NewsFeedModel.Row> rows = new ArrayList<>();
        NewsFeedModel.Row news = new NewsFeedModel().new Row();
        news.setDescription("Description");
        news.setImageHref("https://www.google.com/test.jpg");
        news.setTitle("Title");
        rows.add(news);
        return rows;
    }
}
