package net.osmand.plus.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnChildClickListener;

import net.osmand.plus.R;
import net.osmand.plus.SettingsHelper.SettingsItem;
import net.osmand.plus.base.BaseOsmAndDialogFragment;

import java.util.List;

public class ImportSettingsFragment extends BaseOsmAndDialogFragment
		implements OnChildClickListener, OnGroupClickListener, View.OnClickListener {

	public static final String TAG = ImportSettingsFragment.class.getSimpleName();

	private ExpandableListView listView;

	private Button selectAllBtn;

	private Button continueBtn;

	private List<SettingsItem> settingsItems;

	public static void showInstance(@NonNull FragmentManager fm, @NonNull List<SettingsItem> settingsItems) {
		ImportSettingsFragment fragment = new ImportSettingsFragment();
		fragment.setSettingsItems(settingsItems);
		fragment.show(fm, TAG);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_import, container, false);
		setupToolbar((Toolbar) root.findViewById(R.id.toolbar));
		listView = root.findViewById(android.R.id.list);

		return root;
	}

	@Override
	public void onClick(View view) {

	}

	@Override
	public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
		return false;
	}

	@Override
	public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
		return false;
	}

	public void setSettingsItems(List<SettingsItem> settingsItems) {
		this.settingsItems = settingsItems;
	}

	private void setupToolbar(Toolbar toolbar) {
		toolbar.setNavigationIcon(getPaintedContentIcon(R.drawable.headline_close_button,
				getSettings().isLightContent()
						? getResources().getColor(R.color.active_buttons_and_links_text_light)
						: getResources().getColor(R.color.active_buttons_and_links_text_dark)));
		toolbar.setNavigationContentDescription(R.string.shared_string_close);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
	}

	private boolean isNightMode() {
		return getSettings().isLightContent();
	}
}
