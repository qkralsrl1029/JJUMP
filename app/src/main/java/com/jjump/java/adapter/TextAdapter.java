package com.jjump.java.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jjump.R;
import com.jjump.java.CameraXLivePreviewActivity;
import com.jjump.java.data.WordlistDates;

import java.util.ArrayList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder>{
    private ArrayList<String> mData = null ;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView = itemView.findViewById(R.id.textItem) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public TextAdapter(ArrayList<String> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.item_text, parent, false) ;
        TextAdapter.ViewHolder vh = new TextAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(TextAdapter.ViewHolder holder, int position) {
        String text = mData.get(position) ;
        holder.textView.setText(text) ;
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public void addItem(String data) {
        // 외부에서 item을 추가시킬 함수입니다.
        mData.add(data);
    }
}
