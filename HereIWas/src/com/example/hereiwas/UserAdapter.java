package com.example.hereiwas;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class UserAdapter extends BaseAdapter {

	List<CUser> user;
	
	LayoutInflater inflater;
	
	public UserAdapter (Context context, List<CUser> user)
	{
		inflater = LayoutInflater.from(context);
		this.user = user;
			
	}
	@Override
	public int getCount() {
		return user.size();
	}

	@Override
	public Object getItem(int position) {
	
		return user.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	private class ViewHolder {
		TextView flNomPrenom;
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.itemuser, null);
			
			holder.flNomPrenom = 
			(TextView)convertView.findViewById(R.id.flNomPrenom);
			
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		String NomPrenom = new String (user.get(position).getNom() + " " + user.get(position).getPrenom());
		
		holder.flNomPrenom.setText(NomPrenom);
		
		return convertView;
	
	}

}
