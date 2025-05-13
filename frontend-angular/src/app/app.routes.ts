import { Routes } from '@angular/router';
import  {VehiculosComponent} from './pages/vehiculos/vehiculos.component'
import  {ResenasComponent} from './pages/resenas/resenas.component'
import  {LoginComponent} from './pages/login/login.component'
import { AdminComponent } from './pages/admin/admin.component'
import { RegistrarComponent } from './pages/registrar/registrar.component';
import { ReservacionesComponent } from './pages/reservaciones/reservaciones.component';

export const routes: Routes = [
    {path: 'vehiculos',component: VehiculosComponent},
    {path: 'resenas',component: ResenasComponent},
    {path: 'login', component: LoginComponent},
    {path: 'admin', component: AdminComponent},
    {path: 'registrar' , component: RegistrarComponent},
    {path: 'reservaciones', component: ReservacionesComponent}

    
];
