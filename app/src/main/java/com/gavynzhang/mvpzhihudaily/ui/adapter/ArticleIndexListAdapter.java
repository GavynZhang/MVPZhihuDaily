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
import com.gavynzhang.mvpzhihudaily.ui.activity.ArticleContentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GavynZhang on 2016/11/25 18:45.
 */

public class ArticleIndexListAdapter extends RecyclerView.Adapter {

    //RecyclerView的头部
    private static final int VIEW_HEADER = 0;
    //RecyclerView的主体部分
    private static final int VIEW_ITEM = 1;
    //RecyclerView的分隔线部分
    private static final int VIEW_SEPARATE = 2;

    //RecyclerView的主体数据
    private List<List<ArticleIndex>> indexDataList = new ArrayList<>();
    //RecyclerView分隔标识
    private List<Integer> separateTags = new ArrayList<>();
    private Context mContext = null;
    private View mHeaderView = null;

    public ArticleIndexListAdapter(Context context, List<List<ArticleIndex>> articleIndicesList){
        this.mContext = context;
        this.indexDataList = articleIndicesList;
    }

    public void setHeaderView(View view){
        this.mHeaderView = view;
    }

    /**
     * 用于向RecyclerView中添加一天的数据
     *
     * @param indexData 某一天的ArticleIndex数据
     */
    public void addIndexData(List<ArticleIndex> indexData){
        indexDataList.add(indexData);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_HEADER;
        }else if(isPositionInSeparate(position)){
            return VIEW_SEPARATE;
        }
        return VIEW_ITEM;
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
        final ArticleIndex articleIndex = indexDataList.get(0).get(position);
        vh.getArticleIndexTitleText().setText(articleIndex.getTitle());
        Glide.with(mContext).load(articleIndex.getImage_url()).into(vh.getArticleIndexImageView());

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArticleContentActivity.actionStart(mContext, articleIndex.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < indexDataList.size(); i++){
            size += indexDataList.get(i).size();
        }
        return size;
    }

    public class IndexViewHolder extends RecyclerView.ViewHolder{

        private TextView articleIndexTitleText;
        private ImageView articleIndexImageView;
        private TextView separateText;

        public TextView getSeparateText() {
            return separateText;
        }

        public void setSeparateText(TextView separateText) {
            this.separateText = separateText;
        }

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
            separateText = (TextView)itemView.findViewById(R.id.separate_text);
        }
    }

    public class DateViewHolder extends RecyclerView.ViewHolder{

        private TextView articleIndicesDateText;

        public TextView getArticleIndicesDateText() {
            return articleIndicesDateText;
        }

        public void setArticleIndicesDateText(TextView articleIndicesDateText) {
            this.articleIndicesDateText = articleIndicesDateText;
        }

        public DateViewHolder(View itemView) {
            super(itemView);

            articleIndicesDateText = (TextView)itemView.findViewById(R.id.article_index_title_text);
        }
    }

    /**
     * 判断position是否位于分隔线上
     *
     * @param position 当前item的位置
     * @return 是否位于分隔线上
     */
    private boolean isPositionInSeparate(int position){
        for(int i = 0; i < separateTags.size(); i++){
            if (position == separateTags.get(i)){
                return true;
            }
        }
        return false;
    }

    /**
     * 将分隔线位置保存到List
     */
    private void setSeparateTags(){
        separateTags.add(0,1);
        int itemSize = 2;
        for(int i = 1; i <= indexDataList.size(); i++){
            itemSize += indexDataList.get(i-1).size();
            separateTags.add(itemSize+1);
        }
    }
}
