<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          <#if isInstantApp!false>xmlns:instant="http://schemas.android.com/instantapps"</#if>>

    <application>
        <activity android:name="${relativePackage}.view.${activityClass}"/>
    </application>
</manifest>