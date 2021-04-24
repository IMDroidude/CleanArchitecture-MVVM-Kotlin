<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <!-- <#include "root://activities/common/recipe_manifest.xml.ftl" /> -->
    <@kt.addAllKotlinDependencies />
    <dependency mavenUrl="com.android.support:support-v4:${buildApi}.+"/>
    <dependency mavenUrl="android.arch.lifecycle:extensions:+"/>
    <#assign escapedResOut="${escapeXmlAttribute(resOut)}">
    <#assign escapedSrcOut="${escapeXmlAttribute(srcOut)}">

    <#if generateKotlin && useAndroidX>
        <dependency mavenUrl="androidx.lifecycle:lifecycle-viewmodel-ktx:+"/>
    </#if>

    <#if useAndroidX && !(hasDependency('com.google.dagger:hilt-android'))>
           <dependency mavenUrl="com.google.dagger:hilt-android:2.28-alpha" />
    </#if>

    <!-- <merge from="root/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" /> -->

    <instantiate from="root/res/layout/blank_activity.xml.ftl"
                   to="${escapedResOut}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <open file="${escapedResOut}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="root/src/app_package/BlankActivity.kt.ftl"
                   to="${escapedSrcOut}/${activityClass}.kt" />

    <open file="${escapedSrcOut}/${activityClass}.kt" />

    <instantiate from="root/src/app_package/BlankViewModel.kt.ftl"
                   to="${escapedSrcOut}/${viewModelName}.kt" />
		
	<open file="${escapedSrcOut}/${viewModelName}.kt" />		
	
</recipe>
