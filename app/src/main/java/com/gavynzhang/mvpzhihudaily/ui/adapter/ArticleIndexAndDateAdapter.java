package com.gavynzhang.mvpzhihudaily.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndexAndDate;

import java.util.List;

/**
 * Created by GavynZhang on 2016/12/8 21:51.
 */

public class ArticleIndexAndDateAdapter extends RecyclerView.Adapter {

    private List<ArticleIndexAndDate> mDates;

    public ArticleIndexAndDateAdapter(List<ArticleIndexAndDate> articleIndexAndDates){
        this.mDates = articleIndexAndDates;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDates.size() + getAllIndexNum();
    }

    public class IndexDateViewHolder extends RecyclerView.ViewHolder{


        public IndexDateViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class IndexItemViewHolder extends RecyclerView.ViewHolder{

        public IndexItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * @return  所有文章标签的个数
     */
    private int getAllIndexNum(){
        int size = 0;
        for(int i = 0; i < mDates.size(); i++){
            size += mDates.get(i).getArticleIndices().size();
        }
        return size;
    }
}
