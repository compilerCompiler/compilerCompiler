package com.upb.vlibrary.data.user

import com.upb.vlibrary.Persona
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.UserRegistered
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.data.user.network.UserNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class UserRepository(val network: UserNetworkController) {
    fun login(username:String,password:String):Flow<UserInfo>/*: Flow<Response<UserInfo>>*/ {
        return flow {
            emit(network.login(username,password))
        }
    }

    fun register(username:String, email:String, password:String): Flow<UserRegistered>{
        return flow {
            emit(network.register(username,email,password))
        }
    }
    fun reservation(id_usuario:Int,id_libro:Int,fecha_reservacion:String,fecha_devolucion:String):Flow<Any>{
        return flow {
            emit(network.reservation(id_usuario,id_libro,fecha_reservacion,fecha_devolucion))
        }
    }

    fun createPersona(nombre:String,profesion:String,id_usuario:Int):Flow<Persona>{
        return flow {
            emit(network.createPersona(nombre,profesion,id_usuario))
        }
    }

    fun createAdmi(id_persona:Int,codigo_admi:Int):Flow<Any>{
        return flow{
            emit(network.createAdmi(id_persona,codigo_admi))
        }
    }

    fun getAllUsers():Flow<List<UsuarioPersona>>{
        return flow{
            emit(network.getAllUsers())
        }
    }

    fun deletePersona(id_persona:Int):Flow<Any>{
        return  flow {
            emit(network.deletePersona(id_persona))
        }
    }

    fun deleteUsuario(id_usuario: Int):Flow<Any>{
        return flow {
            emit(network.deleteUsuario(id_usuario))
        }
    }


}