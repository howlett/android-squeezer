package com.danga.squeezer.model;

import java.util.Map;

import com.danga.squeezer.SqueezeItem;
import com.danga.squeezer.Util;

import android.os.Parcel;
import android.os.Parcelable;

public class SqueezePlayer extends SqueezeItem {
	private String ip;
	private String name;
	private boolean canpoweroff;
	private String model;
	
	public SqueezePlayer() {
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public SqueezePlayer setName(String name) {
		this.name = name;
		return this;
	}
	public boolean isCanpoweroff() {
		return canpoweroff;
	}
	public void setCanpoweroff(boolean canpoweroff) {
		this.canpoweroff = canpoweroff;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public SqueezePlayer(Map<String, String> record) {
		setId(record.get("playerid"));
		ip = record.get("ip");
		name = record.get("name");
		model = record.get("model");
		canpoweroff = Util.parseDecimalIntOrZero(record.get("canpoweroff")) == 1;
	}
	
	public static final Parcelable.Creator<SqueezePlayer> CREATOR = new Creator<SqueezePlayer>() {
		public SqueezePlayer[] newArray(int size) {
			return new SqueezePlayer[size];
		}

		public SqueezePlayer createFromParcel(Parcel source) {
			return new SqueezePlayer(source);
		}
	};
	private SqueezePlayer(Parcel source) {
		setId(source.readString());
		ip = source.readString();
		name = source.readString();
		model = source.readString();
		canpoweroff = (source.readByte() == 1);
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getId());
		dest.writeString(ip);
		dest.writeString(name);
		dest.writeString(model);
		dest.writeByte(canpoweroff ? (byte)1 : (byte)0);
	}

	
	@Override
	public String toString() {
		return "id=" + getId() + ", name=" + name + ", model=" + model + ", canpoweroff=" + canpoweroff + ", ip=" + ip;
	}

}
