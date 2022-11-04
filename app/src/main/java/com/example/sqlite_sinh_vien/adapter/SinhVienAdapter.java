package com.example.sqlite_sinh_vien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlite_sinh_vien.R;
import com.example.sqlite_sinh_vien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhVienList;
    private Context context;
    public SinhVienAdapter(Context context, List<SinhVien> listList){
        this.context = context;
        this.sinhVienList = listList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_sinhvien,null);


            viewHolder.tvMaSV = view.findViewById(R.id.tv_masv);
            viewHolder.tvHoTen = view.findViewById(R.id.tv_hoten);
            viewHolder.tvDienThoai = view.findViewById(R.id.tv_dienthoai);
            viewHolder.tvEmail = view.findViewById(R.id.tv_email);
            viewHolder.ivGioiTinh = view.findViewById(R.id.iv_gioitinh);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SinhVien sv = sinhVienList.get(i);
        viewHolder.tvMaSV.setText("Mã SV:"+ sv.getMaSV());
        viewHolder.tvHoTen.setText("Họ tên:"+ sv.getHoTen());
        viewHolder.tvDienThoai.setText("Điện thoại:"+ sv.getDienThoai());
        viewHolder.tvEmail.setText("Email:"+ sv.getEmail());
        if(sv.getGioiTinh() == 0) {
            viewHolder.ivGioiTinh.setImageResource(R.drawable.sv1);
        }
        else {
            viewHolder.ivGioiTinh.setImageResource(R.drawable.sv3);
        }
        return view;
    }
    class ViewHolder{
        ImageView ivGioiTinh;
        TextView tvMaSV, tvHoTen, tvDienThoai, tvEmail;
    }
}
