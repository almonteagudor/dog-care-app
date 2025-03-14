package com.almonteagudor.dogcare.di

import com.almonteagudor.dogcare.data.repository.MedicineRepositoryImpl
import com.almonteagudor.dogcare.domain.repository.MedicineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMedicineRepository(
        implementation: MedicineRepositoryImpl
    ): MedicineRepository
}