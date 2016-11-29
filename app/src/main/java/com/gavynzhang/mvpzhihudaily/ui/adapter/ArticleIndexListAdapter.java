package com.gavynzhang.mvpzhihudaily.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gavynzhang.mvpzhihudaily.R;
import com.gavynzhang.mvpzhihudaily.model.entities.ArticleIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GavynZhang on 2016/11/25 18:45.
 */

public class ArticleIndexListAdapter extends RecyclerView.Adapter {

    private List<ArticleIndex> indexData = new ArrayList<>();
    private Context mContext = null;

    public ArticleIndexListAdapter(Context context, List<ArticleIndex> articleIndices){
        this.mContext = context;
        this.indexData = articleIndices;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_index_item, null);
        IndexViewHolder viewHolder = new IndexViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IndexViewHolder vh = (IndexViewHolder)holder;
        vh.getArticleIndexTitleText().setText(indexData.get(position).getTitle());
        Glide.with(mContext).load(indexData.get(position).getImage_url()).into(vh.getArticleIndexImageView());
    }

    @Override
    public int getItemCount() {
        return indexData.size();
    }

    public class IndexViewHolder extends RecyclerView.ViewHolder{

        private TextView articleIndexTitleText;
        private ImageView articleIndexImageView;

        public ImageView getArticleIndexImageView() {
            return articleIndexImageView;
        }

        public void setArticleIndexImageView(ImageView articleIndexImageView) {
            this.articleIndexImageView = articleIndexImageView;
        }

        public TextView getArticleIndexTitleText() {
            return articleIndexTitleText;
        }

        public void setArticleIndexTitleText(TextView articleIndexTitleText) {
            this.articleIndexTitleText = articleIndexTitleText;
        }

        public IndexViewHolder(View itemView) {
            super(itemView);

            articleIndexTitleText = (TextView)itemView.findViewById(R.id.article_index_title_text);
            articleIndexImageView = (ImageView)itemView.findViewById(R.id.article_index_image);


        }
    }
}
