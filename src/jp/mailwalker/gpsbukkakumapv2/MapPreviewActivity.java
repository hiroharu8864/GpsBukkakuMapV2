package jp.mailwalker.gpsbukkakumapv2;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MapPreviewActivity extends FragmentActivity {

	private SupportMapFragment mSupportMapFragment;
	private static final String HOGE_MAP_FRAGMENT_TAG = "maps_fragment";
	private GoogleMap mGoogleMap;
	private static final int RQS_GooglePlayServices = 1;

	private static final int MENU_A = 0;
	private static final int MENU_B = 1;
	private static final int MENU_C = 2;
	private static final int MENU_D = 3;
	private static final int MENU_E = 4;
	
	// 起点位置情報
	private static final LatLng NIHONBASHI_STA = new LatLng(35.682413, 139.773919);
	private static final LatLng SHINJUKU_STA = new LatLng(35.690921, 139.700258);
	private static final LatLng NINGYOU_STA = new LatLng(35.686307, 139.782285);
	private static final LatLng MONNAKA_STA = new LatLng(35.671984, 139.795787);
	private static final LatLng ASAKUSA_STA = new LatLng(35.713252, 139.792306);

	// 東京１０社
	private static final LatLng NEDU = new LatLng(35.720233, 139.760738); //根津神社
	private static final LatLng SIBA = new LatLng(35.657596, 139.7529324); //芝大神宮
	private static final LatLng KANDA = new LatLng(35.7019582, 139.7679325); //神田神社
	private static final LatLng HIEDA = new LatLng(35.6747102, 139.7395553); //日枝神社
	private static final LatLng KAMEIDO = new LatLng(35.7030721, 139.8206482); //亀戸天神社
	private static final LatLng SHIRAYAMA = new LatLng(35.7220799, 139.7507861); //白山神社
	private static final LatLng SHINAGAWA = new LatLng(35.618472, 139.739613); //品川神社
	private static final LatLng TOMIOKA = new LatLng(35.671913, 139.799607); //富岡八幡宮
	private static final LatLng OOJI = new LatLng(35.7532181, 139.7359609); //王子神社
	private static final LatLng HIKAWA = new LatLng(35.668325, 139.735573); //赤坂氷川神社

	// 下町八福神
	private static final LatLng SUMIYOSHI = new LatLng(35.66799, 139.783319); //住吉神社
	private static final LatLng KOAMI = new LatLng(35.6841242, 139.7804466); //小網神社
	private static final LatLng SUITENGUU = new LatLng(35.683441, 139.785088); //水天宮
	private static final LatLng DAIROKUTENSAKAKI = new LatLng(35.7002356, 139.7892769); //第六天榊神社
	private static final LatLng SHITAYA = new LatLng(35.7107434, 139.7813095); //下谷神社
	private static final LatLng ONOTERUSAKI = new LatLng(35.7133684, 139.7884894); //小野照崎神社
	private static final LatLng OOTORI = new LatLng(35.722501, 139.791961); //鷲神社
	private static final LatLng IMADO = new LatLng(35.7188626, 139.8038462); //今戸神社
	
	// 深川七福神
	// TOMIOKA
	private static final LatLng FUYUKIBENTEN = new LatLng(35.675381, 139.80012); //冬木弁天堂
	private static final LatLng SHINGYO = new LatLng(35.675967, 139.796726); //心行寺
	private static final LatLng ENJYU = new LatLng(35.6785862, 139.8009227); //円珠院
	private static final LatLng RYUKOU = new LatLng(35.6799832, 139.8035362); //龍光院
	private static final LatLng FUKAGAWAINARI = new LatLng(35.6829106, 139.7968452); //深川稲荷神社
	private static final LatLng FUKAGAWAJINMYO = new LatLng(35.6866824, 139.7973062); //深川神明宮

	// 浅草名所七福神
	private static final LatLng SENSOU = new LatLng(35.71464, 139.7968215); //浅草寺
	private static final LatLng ASAKUSA = new LatLng(35.7150055, 139.7974083); //浅草神社
	private static final LatLng HONRYU = new LatLng(35.7169905, 139.8030047); //本龍院
	// IMADO
	private static final LatLng FUDO = new LatLng(35.7269843, 139.8080761); //不動院
	private static final LatLng ISHIHAMA = new LatLng(35.7297785, 139.8081288); //石浜神社
	private static final LatLng YOSHIWARA = new LatLng(35.7228621, 139.7933135); //吉原神社
	// OOTORI
	private static final LatLng YASAKIINARI = new LatLng(35.7135823, 139.7877422); //矢先稲荷神社
	
	// その他メジャーどころ(Default表示)
	private static final LatLng MEIJIJINGU = new LatLng(35.676362, 139.699362); //明治神宮
	private static final LatLng FUKAGAWAFUDOU = new LatLng(35.6728702, 139.7983425); //深川不動堂
	private static final LatLng YASUKUNI = new LatLng(35.694038, 139.742549); //靖国神社
	private static final LatLng DAIJINGU = new LatLng(35.699982, 139.746868); //東京大神宮
	private static final LatLng IKEGAMI = new LatLng(35.5790029, 139.7052636); //池上本門寺
	private static final LatLng ATAGO = new LatLng(35.6647701, 139.7484191); //愛宕神社
	private static final LatLng ZOUJOU = new LatLng(35.6574236, 139.7482079); //増上寺
	private static final LatLng AKAGI = new LatLng(35.7048449, 139.7360508); //赤城神社
	private static final LatLng YUSHIMA = new LatLng(35.707771, 139.768225); //湯島天神
	private static final LatLng IGUSA = new LatLng(35.7160027, 139.5952481); //井草八幡宮
	private static final LatLng YOYOGI = new LatLng(35.6720917, 139.6885757); //代々木八幡宮
	private static final LatLng KONNOU = new LatLng(35.657516, 139.706321); //金王八幡宮
	private static final LatLng NISHIARAI = new LatLng(35.7801624, 139.779997); //西新井大師
	private static final LatLng SUWA = new LatLng(35.727772, 139.770987); //日暮里諏訪神社
	private static final LatLng AKATSUKA = new LatLng(35.7813125, 139.6477848); //赤塚松月院
	private static final LatLng YUUTEN = new LatLng(35.6372494, 139.6930301); //目黒祐天寺
	private static final LatLng ANAHACHI = new LatLng(35.7072201, 139.7172649); //穴八幡宮
	private static final LatLng ASAMA = new LatLng(35.5875538, 139.6687133); //多摩川浅間神社
	private static final LatLng SETAGAYA = new LatLng(35.6480135, 139.6444646); //世田谷八幡宮
	private static final LatLng KITAMIHIKAWA = new LatLng(35.628796, 139.5929953); //喜多見氷川神社
	private static final LatLng GOTOKU = new LatLng(35.653635, 139.647322); //豪徳寺
	private static final LatLng OOMIYA = new LatLng(35.6823842, 139.6397384); //大宮八幡宮

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_preview);
		// 地図表示
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag(HOGE_MAP_FRAGMENT_TAG);
		mSupportMapFragment = (SupportMapFragment) fragment;
		if (mSupportMapFragment == null) {
			GoogleMapOptions googleOptions = new GoogleMapOptions();
			googleOptions.compassEnabled(true);
			googleOptions.rotateGesturesEnabled(true);
			googleOptions.scrollGesturesEnabled(true);
			googleOptions.tiltGesturesEnabled(true);
			// SupportMapFragment生成
			mSupportMapFragment = SupportMapFragment.newInstance(googleOptions);
			// FragmentTransaction
			FragmentTransaction fTransaction = fragmentManager.beginTransaction();
			fTransaction.add(android.R.id.content, mSupportMapFragment, HOGE_MAP_FRAGMENT_TAG);
			fTransaction.commit();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getApplicationContext());

		if (resultCode == ConnectionResult.SUCCESS) {
			Toast.makeText(getApplicationContext(), "ようこそ、東京23区仏閣MAPへ！",
					Toast.LENGTH_LONG).show();

			// GoogleMaps
			mGoogleMap = mSupportMapFragment.getMap();
			mGoogleMap.setIndoorEnabled(true);
			mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			mGoogleMap.setMyLocationEnabled(true);
			mGoogleMap.setTrafficEnabled(true);
			
			mGoogleMap.clear();
			
			// Maker
			mGoogleMap.addMarker(new MarkerOptions().position(MEIJIJINGU).title("明治神宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUKAGAWAFUDOU).title("深川不動堂").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YASUKUNI).title("靖国神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(DAIJINGU).title("東京大神宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(IKEGAMI).title("池上本門寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ATAGO).title("愛宕神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ZOUJOU).title("増上寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(AKAGI).title("赤城神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YUSHIMA).title("湯島天神").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(IGUSA).title("井草八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YOYOGI).title("代々木八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(KONNOU).title("金王八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(NISHIARAI).title("西新井大師").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(SUWA).title("日暮里諏訪神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(AKATSUKA).title("赤塚松月院").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YUUTEN).title("目黒祐天寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ANAHACHI).title("穴八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ASAMA).title("多摩川浅間神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(SETAGAYA).title("世田谷八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(KITAMIHIKAWA).title("喜多見氷川神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(GOTOKU).title("豪徳寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(OOMIYA).title("大宮八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			
			// 初期位置(日本橋)
			LatLng target = SHINJUKU_STA;
			// ズームレベル
			float zoom = 10.5f;
			// チルトアングル
			float tilt = 90.0f; // 0.0 - 90.0
			// 向き
			float bearing = 0.0f;
			// CameraUpdate
			CameraPosition pos = new CameraPosition(target, zoom, tilt, bearing);
			CameraUpdate camera = CameraUpdateFactory.newCameraPosition(pos);

			mGoogleMap.moveCamera(camera);

			// UiSettings
			UiSettings uiSet = mGoogleMap.getUiSettings();
			uiSet.setZoomControlsEnabled(true);
			uiSet.setZoomGesturesEnabled(true);
			// uiSet.setCompassEnabled(true);
			uiSet.setRotateGesturesEnabled(true);
		} else {
			GooglePlayServicesUtil.getErrorDialog(resultCode, this, RQS_GooglePlayServices);
		}
	}
			
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.map_preview, menu);
		menu.add(0, MENU_A, 0, "東京10社");
		menu.add(0, MENU_B, 0, "下町八福神");
		menu.add(0, MENU_C, 0, "深川七福神");
		menu.add(0, MENU_D, 0, "浅草名所七福神");
		menu.add(0, MENU_E, 0, "戻る");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_A:
			mGoogleMap.clear();
			
			mGoogleMap.addMarker(new MarkerOptions().position(NEDU).title("根津神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(SIBA).title("芝大神宮").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(KANDA).title("神田神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(HIEDA).title("日枝神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(KAMEIDO).title("亀戸天神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(SHIRAYAMA).title("白山神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(SHINAGAWA).title("品川神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(TOMIOKA).title("富岡八幡宮").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(OOJI).title("王子神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			mGoogleMap.addMarker(new MarkerOptions().position(HIKAWA).title("赤坂氷川神社").snippet("東京10社")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

			// 初期位置(日本橋)
			LatLng target = NIHONBASHI_STA;
			// ズームレベル(東京10社用)
			float zoom = 12.0f;
			// チルトアングル
			float tilt = 90.0f; // 0.0 - 90.0
			// 向き
			float bearing = 0.0f;
			// CameraUpdate
			CameraPosition pos = new CameraPosition(target, zoom, tilt, bearing);
			CameraUpdate camera = CameraUpdateFactory.newCameraPosition(pos);
			mGoogleMap.moveCamera(camera);

			return true;
		
		case MENU_B:
			mGoogleMap.clear();
			
			mGoogleMap.addMarker(new MarkerOptions().position(SUMIYOSHI).title("住吉神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(KOAMI).title("小網神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(SUITENGUU).title("水天宮").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(DAIROKUTENSAKAKI).title("第六天榊神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(SHITAYA).title("下谷神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(ONOTERUSAKI).title("小野照崎神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(OOTORI).title("鷲神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			mGoogleMap.addMarker(new MarkerOptions().position(IMADO).title("今戸神社").snippet("下町八福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
			
			LatLng target2 = NINGYOU_STA;
			// ズームレベル
			float zoom2 = 13.0f;
			float tilt2 = 90.0f;
			float bearing2 = 0.0f;
			CameraPosition pos2 = new CameraPosition(target2, zoom2, tilt2, bearing2);
			CameraUpdate camera2 = CameraUpdateFactory.newCameraPosition(pos2);
			mGoogleMap.moveCamera(camera2);

			return true;

		case MENU_C:
			mGoogleMap.clear();
			
			mGoogleMap.addMarker(new MarkerOptions().position(TOMIOKA).title("富岡八幡宮").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUYUKIBENTEN).title("冬木弁天堂").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(SHINGYO).title("心行寺").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(ENJYU).title("円珠院").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(RYUKOU).title("龍光院").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUKAGAWAINARI).title("深川稲荷神社").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUKAGAWAJINMYO).title("深川神明宮").snippet("深川七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
			
			LatLng target3 = MONNAKA_STA;
			// ズームレベル
			float zoom3 = 14.0f;
			float tilt3 = 90.0f;
			float bearing3 = 0.0f;
			CameraPosition pos3 = new CameraPosition(target3, zoom3, tilt3, bearing3);
			CameraUpdate camera3 = CameraUpdateFactory.newCameraPosition(pos3);
			mGoogleMap.moveCamera(camera3);
			
			return true;
			
		case MENU_D:
			mGoogleMap.clear();

			mGoogleMap.addMarker(new MarkerOptions().position(SENSOU).title("浅草寺").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(ASAKUSA).title("浅草神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(HONRYU).title("本龍院").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(IMADO).title("今戸神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUDO).title("不動院").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(ISHIHAMA).title("石浜神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(YOSHIWARA).title("吉原神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(OOTORI).title("鷲神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			mGoogleMap.addMarker(new MarkerOptions().position(YASAKIINARI).title("矢先稲荷神社").snippet("浅草名所七福神")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
			
			LatLng target4 = ASAKUSA_STA;
			// ズームレベル
			float zoom4 = 14.0f;
			float tilt4 = 90.0f;
			float bearing4 = 0.0f;
			CameraPosition pos4 = new CameraPosition(target4, zoom4, tilt4, bearing4);
			CameraUpdate camera4 = CameraUpdateFactory.newCameraPosition(pos4);
			mGoogleMap.moveCamera(camera4);

			return true;
			
		case MENU_E:
			mGoogleMap.clear();

			mGoogleMap.addMarker(new MarkerOptions().position(MEIJIJINGU).title("明治神宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(FUKAGAWAFUDOU).title("深川不動堂").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YASUKUNI).title("靖国神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(DAIJINGU).title("東京大神宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(IKEGAMI).title("池上本門寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ATAGO).title("愛宕神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ZOUJOU).title("増上寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(AKAGI).title("赤城神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YUSHIMA).title("湯島天神").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(IGUSA).title("井草八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YOYOGI).title("代々木八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(KONNOU).title("金王八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(NISHIARAI).title("西新井大師").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(SUWA).title("日暮里諏訪神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(AKATSUKA).title("赤塚松月院").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(YUUTEN).title("目黒祐天寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ANAHACHI).title("穴八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(ASAMA).title("多摩川浅間神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(SETAGAYA).title("世田谷八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(KITAMIHIKAWA).title("喜多見氷川神社").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(GOTOKU).title("豪徳寺").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			mGoogleMap.addMarker(new MarkerOptions().position(OOMIYA).title("大宮八幡宮").snippet("東京仏閣MAP")
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

			LatLng target5 = SHINJUKU_STA;
			float zoom5 = 10.5f;
			float tilt5 = 90.0f; // 0.0 - 90.0
			float bearing5 = 0.0f;
			CameraPosition pos5 = new CameraPosition(target5, zoom5, tilt5, bearing5);
			CameraUpdate camera5 = CameraUpdateFactory.newCameraPosition(pos5);

			mGoogleMap.moveCamera(camera5);

			return true;
		}
		return false;
	}
}
