package com.mancy.shoppingmall_1020_2.home.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.shoppingmall_1020_2.R;
import com.mancy.shoppingmall_1020_2.bean.HomeBean;
import com.mancy.shoppingmall_1020_2.utils.Constants;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mancy on 2017/2/23.
 */

public class ChannelAdapter extends BaseAdapter {

    private final Context context;
    private final List<HomeBean.ResultBean.ChannelInfoBean> datas;

    public ChannelAdapter(Context context, List<HomeBean.ResultBean.ChannelInfoBean> channel_info) {


        this.context = context;
        this.datas = channel_info;


    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {


            convertView = View.inflate(context, R.layout.item_channel, null);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();


        }


        // 根据位置 取对应的数据


        HomeBean.ResultBean.ChannelInfoBean channelInfoBean = datas.get(position);

        //  获取item的  名称


        viewHolder.tvChannel.setText(channelInfoBean.getChannel_name());

        //Glide请求图片
        Glide.with(context)
                .load(Constants.BASE_URL_IMAGE + channelInfoBean.getImage())
                .crossFade()
                .into(viewHolder.ivChannel);


        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_channel)
        ImageView ivChannel;
        @InjectView(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
