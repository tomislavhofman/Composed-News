package hr.hofman.composednews.di

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import hr.hofman.composednews.data.local.ComposedNewsDatabase
import hr.hofman.composednews.data.local.ComposedNewsEntityInserter
import hr.hofman.composednews.data.local.ComposedNewsRoomDatabase
import hr.hofman.composednews.data.local.entity.EntityInserter
import javax.inject.Singleton

@Module(
    includes = [
        RoomDatabaseModule::class,
        DatabaseModuleBinds::class,
        DatabaseDaoModule::class]
)
class DatabaseModule

@Module
object RoomDatabaseModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): ComposedNewsRoomDatabase {
        val builder = Room.databaseBuilder(context, ComposedNewsRoomDatabase::class.java, "composed-news.db")
            .fallbackToDestructiveMigration()
        if(Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }
}

@Module
object DatabaseDaoModule {

    @JvmStatic
    @Provides
    fun provideHeadlinesDao(db: ComposedNewsDatabase) = db.headlinesDao()
}

@Module
abstract class DatabaseModuleBinds {

    @Singleton
    @Binds
    abstract fun bindsComposedNewsDatabase(db: ComposedNewsRoomDatabase): ComposedNewsDatabase

    @Singleton
    @Binds
    abstract fun bindsEntityInserter(inserter: ComposedNewsEntityInserter): EntityInserter
}