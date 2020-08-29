package lxt.project.myapplication.dependency;

import android.content.Context;

import java.security.Security;

import b.laixuantam.myaarlibrary.api.ApiManagement;
import b.laixuantam.myaarlibrary.helper.AppCleanerHelper;
import b.laixuantam.myaarlibrary.helper.AuthHelper;
import b.laixuantam.myaarlibrary.helper.ConnectivityHelper;
import b.laixuantam.myaarlibrary.helper.FileHelper;
import b.laixuantam.myaarlibrary.helper.ImageHelper;
import b.laixuantam.myaarlibrary.helper.InstallationHelper;
import b.laixuantam.myaarlibrary.helper.LanguageHelper;
//import lxt.project.myapplication.database.DatabaseHelper;
import lxt.project.myapplication.helper.SharePrefs;

/**
 * Custom object provider for the normal execution of the application. It provides the default
 * implementation of the objects.
 */
public class AppObjectProvider implements ObjectProviderInterface {
    private final Context context;

    // singleton instances
    private SharePrefs preferences;
    private InstallationHelper installationHelper;
    private Security security;
//    private DatabaseHelper databaseHelper;
    private ImageHelper imageHelper;
    private AppCleanerHelper appCleanerHelper;
    private FileHelper fileHelper;
    private ConnectivityHelper connectivityHelper;
    private ApiManagement apiManagement;
    private LanguageHelper languageHelper;
    private AuthHelper authHelper;

    public AppObjectProvider(Context context) {
        this.context = context;

        b.laixuantam.myaarlibrary.dependency.ObjectProviderInterface objectProviderInterface1 = new b.laixuantam.myaarlibrary.dependency.AppObjectProvider(context);

        b.laixuantam.myaarlibrary.dependency.AppProvider.init(objectProviderInterface1);
    }

//    @Override
//    public DatabaseHelper getDatabaseHelper() {
//        return (databaseHelper == null) ? (databaseHelper = new DatabaseHelper(context)) : databaseHelper;
//    }

    @Override
    public ImageHelper getImageHelper() {
        return (imageHelper == null) ? (imageHelper = new ImageHelper(context)) : imageHelper;
    }

    @Override
    public SharePrefs getPreferences() {
        return (preferences == null) ? (preferences = new SharePrefs(context)) : preferences;
    }

    @Override
    public InstallationHelper getInstallationHelper() {
        return (installationHelper == null) ? (installationHelper = new InstallationHelper(context)) : installationHelper;
    }

    @Override
    public AppCleanerHelper getAppCleanerHelper() {
        return (appCleanerHelper == null) ? (appCleanerHelper = new AppCleanerHelper(context, getInstallationHelper())) : appCleanerHelper;
    }

    public FileHelper getFileHelper() {
        return (fileHelper == null) ? (fileHelper = new FileHelper(context)) : fileHelper;
    }

    @Override
    public ConnectivityHelper getConnectivityHelper() {
        return (connectivityHelper == null) ? (connectivityHelper = new ConnectivityHelper(context)) : connectivityHelper;
    }

    public ApiManagement getApiManagement() {
        return (apiManagement == null) ? (apiManagement = new ApiManagement()) : apiManagement;
    }

    @Override
    public LanguageHelper getLanguageHelper() {
        return (languageHelper == null) ? (languageHelper = new LanguageHelper()) : languageHelper;
    }

    @Override
    public AuthHelper getAuthHelper() {
        return (authHelper == null) ? (authHelper = new AuthHelper()) : authHelper;
    }
}