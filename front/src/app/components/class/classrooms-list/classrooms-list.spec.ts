import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomsList } from './classrooms-list';

describe('ClassroomList', () => {
  let component: ClassroomsList;
  let fixture: ComponentFixture<ClassroomsList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassroomsList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassroomsList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
