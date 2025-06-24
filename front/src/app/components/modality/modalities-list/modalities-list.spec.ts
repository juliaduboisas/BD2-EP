import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalitiesList } from './modalities-list';

describe('ModalitiesList', () => {
  let component: ModalitiesList;
  let fixture: ComponentFixture<ModalitiesList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalitiesList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalitiesList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
