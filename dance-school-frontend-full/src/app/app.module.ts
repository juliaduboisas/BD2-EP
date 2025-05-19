import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { StudentListComponent } from './student/student-list/student-list.component';
import { StudentFormComponent } from './student/student-form/student-form.component';
import { RoomListComponent } from './room/room-list/room-list.component';
import { RoomFormComponent } from './room/room-form/room-form.component';
import { ClassroomListComponent } from './classroom/classroom-list/classroom-list.component';
import { ClassroomFormComponent } from './classroom/classroom-form/classroom-form.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentFormComponent,
    RoomListComponent,
    RoomFormComponent,
    ClassroomListComponent,
    ClassroomFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
