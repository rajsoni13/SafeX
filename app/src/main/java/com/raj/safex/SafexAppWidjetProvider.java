package com.raj.safex;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;



public class SafexAppWidjetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int appWidjetId : appWidgetIds) {

            Intent intent = new Intent(context, HomeFragment.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.example_widjet);

            views.setOnClickPendingIntent(R.id.btn_widjet,pendingIntent);

            appWidgetManager.updateAppWidget(appWidjetId,views);

        }
    }
}
