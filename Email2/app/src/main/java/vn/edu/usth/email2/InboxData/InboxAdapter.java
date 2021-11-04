package vn.edu.usth.email2.InboxData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.edu.usth.email2.IbDetailActivity;
import vn.edu.usth.email2.R;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.InboxViewHolder> {

    private List<InboxDetail> mIbData;
    private Context mContext;


    public InboxAdapter(Context mContext, List<InboxDetail> mIbData) {
        this.mIbData = mIbData;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_inbox_list, parent, false);
        return new InboxViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {
        holder.mIbSender.setText(mIbData.get(position).getIbSender());
        holder.mIbTitle.setText(mIbData.get(position).getIbTitle());
        holder.mIbDetails.setText(mIbData.get(position).getIbDetails());
        holder.mRcvTime.setText(mIbData.get(position).getRcvTime());
        holder.mIbIcon.setText(mIbData.get(position).getIbSender().substring(0, 1));
        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.mIbIcon.getBackground()).setColor(color);
        int color2 = Color.argb(255,241,181,3);
        holder.mIbStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (holder.mIbStar.getColorFilter() != null) {
                    holder.mIbStar.clearColorFilter();
                } else {
                    holder.mIbStar.setColorFilter(color2);
                }
            }
        });
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, IbDetailActivity.class);
                intent.putExtra("sender",holder.mIbSender.getText().toString());
                intent.putExtra("title",holder.mIbTitle.getText().toString());
                intent.putExtra("detail",holder.mIbDetails.getText().toString());
                intent.putExtra("icon",holder.mIbIcon.getText().toString());
                intent.putExtra("time",holder.mRcvTime.getText().toString());
                intent.putExtra("colorIcon",color);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mIbData.size();
    }

    class InboxViewHolder extends RecyclerView.ViewHolder {

        TextView mIbIcon;
        TextView mIbSender;
        TextView mIbTitle;
        TextView mIbDetails;
        TextView mRcvTime;
        ImageView mIbStar;
        RelativeLayout mLayout;

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            mIbIcon = itemView.findViewById(R.id.ic_sender);
            mIbSender = itemView.findViewById(R.id.ib_sender);
            mIbTitle = itemView.findViewById(R.id.ib_title);
            mIbDetails = itemView.findViewById(R.id.ib_detail);
            mRcvTime = itemView.findViewById(R.id.rcv_time);
            mIbStar = itemView.findViewById(R.id.starro);
            mLayout = itemView.findViewById(R.id.inbox_list);
        }
    }



}