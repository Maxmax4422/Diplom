package com.example.profissional

import android.app.Application
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest

class MyApp():Application() {
    companion object{
        lateinit var supabase:SupabaseClient
    }

    override fun onCreate() {
        super.onCreate()
        supabase = createSupabaseClient(
            supabaseUrl = "https://vbwsazqfseexvojundvx.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZid3NhenFmc2VleHZvanVuZHZ4Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcwNzk3ODg1MSwiZXhwIjoyMDIzNTU0ODUxfQ.0GlhrRjUY4RL1OagERvBo5omhsA_p3bhqDi8dJyHCuI"
        ){
            install(Auth){
                autoLoadFromStorage = false
            }
            install(Postgrest)
        }
    }
}