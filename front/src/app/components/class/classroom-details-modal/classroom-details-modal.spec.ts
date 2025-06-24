import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassroomDetailsModal } from './classroom-details-modal';

describe('ClassroomDetailsModal', () => {
  let component: ClassroomDetailsModal;
  let fixture: ComponentFixture<ClassroomDetailsModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassroomDetailsModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassroomDetailsModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
